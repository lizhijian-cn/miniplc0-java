package miniplc0java;

import miniplc0java.analyser.Analyser;
import miniplc0java.error.CompileError;
import miniplc0java.instruction.Instruction;
import miniplc0java.tokenizer.StringIter;
import miniplc0java.tokenizer.Tokenizer;
import miniplc0java.vm.MiniVm;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Miniplc0Test {
    @Test
    public void testApp() throws CompileError {
        String input = "begin \n" +
                "const a =-1; const b=+2; var c;var d=b; \n" +
                "print(a*b+d);\n" +
                "c=-3;\n" +
                "print(a+b*c+d);\n" +
                "end";
        var scanner = new Scanner(input);
        var iter = new StringIter(scanner);
        var tokenizer = new Tokenizer(iter);
        var analyzer = new Analyser(tokenizer);
        List<Instruction> instructions = analyzer.analyse();

        for (Instruction instruction : instructions)
            System.out.println(instruction);
        System.out.println("------------------------");
        var vm = new MiniVm(instructions, System.out);
        vm.Run();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class find_java {
    public static void main(String[] args) {
        System.out.println(checkJava());
    }

    public static String checkJava() {
        // 不同操作系统的命令略有差异，但"java -version"在主流系统中通用
        String command = "java -version";
        Process process = null;
        try {
            // 执行命令
            process = Runtime.getRuntime().exec(command);

            // 读取错误流（java -version的输出默认在错误流）
            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            // 等待命令执行完成并获取退出码（0表示成功）
            int exitCode = process.waitFor();

            // 若退出码为0，且能读取到版本信息，说明Java已安装
            if (exitCode == 0 && errorReader.readLine() != null) {
                return "java";
            }
        } catch (IOException | InterruptedException e) {
            // 执行命令失败（如找不到java命令）
            return "not find java";
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
        return "not find java";
    }
}
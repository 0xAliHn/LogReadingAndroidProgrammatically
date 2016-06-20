package com.android.alihn.LogReading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ali on 6/9/16.
 */
public class LogsUtil {
    private static final String processId = Integer.toString(android.os.Process
            .myPid());

    public static StringBuilder readLogs() {
        StringBuilder logBuilder = new StringBuilder();
        try {
            String[] command = new String[] { "logcat", "-d", "threadtime" };
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(processId)) {
                    logBuilder.append(line);
                    //Code here
                }
            }
        } catch (IOException e) {
        }
        return logBuilder;
    }
}

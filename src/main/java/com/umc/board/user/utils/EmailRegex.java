package com.umc.board.user.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {

    public static boolean isValidEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            return true;
        }
        return false;
    }
}

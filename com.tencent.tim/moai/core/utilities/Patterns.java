package moai.core.utilities;

import android.util.Log;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ayangxu.
 */
public class Patterns {
    private final static ConcurrentHashMap<String, ThreadLocal<Matcher>> patterns =
            new ConcurrentHashMap<>();

    public static boolean match(String regex, String str) {
        return matcher(regex, str).find();
    }

    public static Matcher matcher(final String regex, String str) {
        if (!patterns.containsKey(regex)) {
            patterns.putIfAbsent(regex, new ThreadLocal<Matcher>() {
                @Override
                protected Matcher initialValue() {
                    Log.d("pattern", "regex: " + regex);
                    return Pattern.compile(regex).matcher("");
                }
            });
        }
        return patterns.get(regex).get().reset(str);
    }

    public static String replace(String regex, String str, String replace) {
        return matcher(regex, str).replaceFirst(replace);
    }

    public static List<Range<Integer>> ranges(String pattern, String text) {
        List<Range<Integer>> ranges = Lists.newArrayList();
        if (!Strings.isNullOrEmpty(text)) {
            Matcher matcher = matcher(pattern, text);
            while (matcher.find()) {
                ranges.add(Range.closedOpen(matcher.start(), matcher.end()));
            }
        }
        return ranges;
    }
}

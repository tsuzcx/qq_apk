package moai.core.utilities;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;

public class Patterns
{
  private static final ConcurrentHashMap<String, ThreadLocal<Matcher>> patterns = new ConcurrentHashMap();
  
  public static boolean match(String paramString1, String paramString2)
  {
    return matcher(paramString1, paramString2).find();
  }
  
  public static Matcher matcher(String paramString1, String paramString2)
  {
    if (!patterns.containsKey(paramString1)) {
      patterns.putIfAbsent(paramString1, new Patterns.1(paramString1));
    }
    return ((Matcher)((ThreadLocal)patterns.get(paramString1)).get()).reset(paramString2);
  }
  
  public static List<Range<Integer>> ranges(String paramString1, String paramString2)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (!Strings.isNullOrEmpty(paramString2))
    {
      paramString1 = matcher(paramString1, paramString2);
      while (paramString1.find()) {
        localArrayList.add(Range.closedOpen(Integer.valueOf(paramString1.start()), Integer.valueOf(paramString1.end())));
      }
    }
    return localArrayList;
  }
  
  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    return matcher(paramString1, paramString2).replaceFirst(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Patterns
 * JD-Core Version:    0.7.0.1
 */
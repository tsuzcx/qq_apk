package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class FindAddress
{
  private static final String HOUSE_COMPONENT = "(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
  private static final String HOUSE_END = "(?=[,\"'\t                　\n\013\f\r  ]|$)";
  private static final String HOUSE_POST_DELIM = ",\"'\t                　\n\013\f\r  ";
  private static final String HOUSE_PRE_DELIM = ":,\"'\t                　\n\013\f\r  ";
  private static final int MAX_ADDRESS_LINES = 5;
  private static final int MAX_ADDRESS_WORDS = 14;
  private static final int MAX_LOCATION_NAME_DISTANCE = 5;
  private static final int MIN_ADDRESS_WORDS = 4;
  private static final String NL = "\n\013\f\r  ";
  private static final String SP = "\t                　";
  private static final String WORD_DELIM = ",*•\t                　\n\013\f\r  ";
  private static final String WORD_END = "(?=[,*•\t                　\n\013\f\r  ]|$)";
  private static final String WS = "\t                　\n\013\f\r  ";
  private static final int kMaxAddressNameWordLength = 25;
  private static final Pattern sHouseNumberRe;
  private static final Pattern sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  private static final Pattern sStateRe;
  private static final ZipRange[] sStateZipCodeRanges = { new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1) };
  private static final Pattern sSuffixedNumberRe = Pattern.compile("(\\d+)(st|nd|rd|th)", 2);
  private static final Pattern sWordRe = Pattern.compile("[^,*•\t                　\n\013\f\r  ]+(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  private static final Pattern sZipCodeRe = Pattern.compile("(?:\\d{5}(?:-\\d{4})?)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  
  static
  {
    sHouseNumberRe = Pattern.compile("(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\013\f\r  ]|$)", 2);
    sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  }
  
  private static int attemptMatch(String paramString, MatchResult paramMatchResult)
  {
    int j = -1;
    int k = -1;
    int i = paramMatchResult.end();
    int i1 = 1;
    int n = 1;
    int m = 0;
    int i2 = 1;
    paramMatchResult = "";
    Matcher localMatcher = sWordRe.matcher(paramString);
    label60:
    label86:
    int i3;
    if (i < paramString.length())
    {
      if (!localMatcher.find(i))
      {
        m = -paramString.length();
        return m;
      }
      if (localMatcher.end() - localMatcher.start() > 25) {
        return -localMatcher.end();
      }
      while (i < localMatcher.start())
      {
        i3 = i + 1;
        if ("\n\013\f\r  ".indexOf(paramString.charAt(i)) == -1) {
          break label491;
        }
        i1 += 1;
        i = i3;
      }
      if (i1 <= 5) {}
    }
    for (;;)
    {
      label132:
      m = k;
      if (k > 0) {
        break label60;
      }
      if (j > 0) {}
      for (;;)
      {
        return -j;
        i2 += 1;
        if (i2 > 14) {
          break label132;
        }
        int i5;
        int i6;
        int i4;
        if (matchHouseNumber(paramString, i) != null)
        {
          if ((n != 0) && (i1 > 1)) {
            return -i;
          }
          i5 = m;
          i6 = n;
          i3 = k;
          i4 = j;
          if (j == -1)
          {
            i4 = i;
            i3 = k;
            i6 = n;
            i5 = m;
          }
        }
        for (;;)
        {
          paramMatchResult = localMatcher.group(0);
          i = localMatcher.end();
          m = i5;
          n = i6;
          k = i3;
          j = i4;
          break;
          n = 0;
          if (isValidLocationName(localMatcher.group(0)))
          {
            i5 = 1;
            i6 = n;
            i3 = k;
            i4 = j;
          }
          else
          {
            if ((i2 == 5) && (m == 0))
            {
              i = localMatcher.end();
              break label132;
            }
            i5 = m;
            i6 = n;
            i3 = k;
            i4 = j;
            if (m != 0)
            {
              i5 = m;
              i6 = n;
              i3 = k;
              i4 = j;
              if (i2 > 4)
              {
                MatchResult localMatchResult = matchState(paramString, i);
                i5 = m;
                i6 = n;
                i3 = k;
                i4 = j;
                if (localMatchResult != null)
                {
                  if ((paramMatchResult.equals("et")) && (localMatchResult.group(0).equals("al")))
                  {
                    i = localMatchResult.end();
                    break label132;
                  }
                  paramMatchResult = sWordRe.matcher(paramString);
                  if (paramMatchResult.find(localMatchResult.end()))
                  {
                    i5 = m;
                    i6 = n;
                    i3 = k;
                    i4 = j;
                    if (isValidZipCode(paramMatchResult.group(0), localMatchResult)) {
                      return paramMatchResult.end();
                    }
                  }
                  else
                  {
                    i3 = localMatchResult.end();
                    i5 = m;
                    i6 = n;
                    i4 = j;
                  }
                }
              }
            }
          }
        }
        j = i;
      }
      label491:
      i = i3;
      break label86;
    }
  }
  
  private static boolean checkHouseNumber(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (Character.isDigit(paramString.charAt(i))) {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 5) {}
    do
    {
      return false;
      paramString = sSuffixedNumberRe.matcher(paramString);
      if (!paramString.find()) {
        break;
      }
      i = Integer.parseInt(paramString.group(1));
    } while (i == 0);
    String str = paramString.group(2).toLowerCase(Locale.getDefault());
    switch (i % 10)
    {
    default: 
      return str.equals("th");
    case 1: 
      if (i % 100 == 11) {}
      for (paramString = "th";; paramString = "st") {
        return str.equals(paramString);
      }
    case 2: 
      if (i % 100 == 12) {}
      for (paramString = "th";; paramString = "nd") {
        return str.equals(paramString);
      }
    }
    if (i % 100 == 13) {}
    for (paramString = "th";; paramString = "rd") {
      return str.equals(paramString);
    }
    return true;
  }
  
  static String findAddress(String paramString)
  {
    Matcher localMatcher = sHouseNumberRe.matcher(paramString);
    int i = 0;
    while (localMatcher.find(i)) {
      if (checkHouseNumber(localMatcher.group(0)))
      {
        i = localMatcher.start();
        int j = attemptMatch(paramString, localMatcher);
        if (j > 0) {
          return paramString.substring(i, j);
        }
        i = -j;
      }
      else
      {
        i = localMatcher.end();
      }
    }
    return null;
  }
  
  @VisibleForTesting
  public static boolean isValidLocationName(String paramString)
  {
    return sLocationNameRe.matcher(paramString).matches();
  }
  
  @VisibleForTesting
  public static boolean isValidZipCode(String paramString)
  {
    return sZipCodeRe.matcher(paramString).matches();
  }
  
  @VisibleForTesting
  public static boolean isValidZipCode(String paramString1, String paramString2)
  {
    return isValidZipCode(paramString1, matchState(paramString2, 0));
  }
  
  private static boolean isValidZipCode(String paramString, MatchResult paramMatchResult)
  {
    if (paramMatchResult == null) {
      return false;
    }
    int i = paramMatchResult.groupCount();
    int j;
    if (i > 0)
    {
      j = i - 1;
      if (paramMatchResult.group(i) == null) {}
    }
    for (;;)
    {
      if ((sZipCodeRe.matcher(paramString).matches()) && (sStateZipCodeRanges[j].matches(paramString))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      i = j;
      break;
      j = i;
    }
  }
  
  @VisibleForTesting
  public static MatchResult matchHouseNumber(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (":,\"'\t                　\n\013\f\r  ".indexOf(paramString.charAt(paramInt - 1)) == -1)) {}
    do
    {
      do
      {
        return null;
        paramString = sHouseNumberRe.matcher(paramString).region(paramInt, paramString.length());
      } while (!paramString.lookingAt());
      paramString = paramString.toMatchResult();
    } while (!checkHouseNumber(paramString.group(0)));
    return paramString;
  }
  
  @VisibleForTesting
  public static MatchResult matchState(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (",*•\t                　\n\013\f\r  ".indexOf(paramString.charAt(paramInt - 1)) == -1)) {}
    do
    {
      return null;
      paramString = sStateRe.matcher(paramString).region(paramInt, paramString.length());
    } while (!paramString.lookingAt());
    return paramString.toMatchResult();
  }
  
  static class ZipRange
  {
    int mException1;
    int mException2;
    int mHigh;
    int mLow;
    
    ZipRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.mLow = paramInt1;
      this.mHigh = paramInt2;
      this.mException1 = paramInt3;
      this.mException2 = paramInt4;
    }
    
    boolean matches(String paramString)
    {
      boolean bool = false;
      int i = Integer.parseInt(paramString.substring(0, 2));
      if (((this.mLow <= i) && (i <= this.mHigh)) || (i == this.mException1) || (i == this.mException2)) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.text.util.FindAddress
 * JD-Core Version:    0.7.0.1
 */
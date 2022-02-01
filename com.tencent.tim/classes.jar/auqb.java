import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.PadInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class auqb
{
  public static String Fg()
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
  }
  
  public static String Fh()
  {
    return new SimpleDateFormat("yyyy").format(new Date());
  }
  
  public static String bG(long paramLong)
  {
    try
    {
      String str = cr(paramLong);
      if (str.equals("今天")) {
        return "今天 " + cn(paramLong);
      }
      if (str.equals("昨天")) {
        return "昨天 " + cn(paramLong);
      }
      str = cp(paramLong);
      return str;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return "";
  }
  
  public static long c(Object paramObject)
  {
    if (((paramObject instanceof FileManagerEntity)) && (((FileManagerEntity)paramObject).cloudFile != null)) {
      return ((FileManagerEntity)paramObject).getSortTime();
    }
    if ((paramObject instanceof atin)) {
      return ((atin)paramObject).getSortTime();
    }
    if (((paramObject instanceof FileManagerEntity)) && (((FileManagerEntity)paramObject).combinePhotoList != null) && (((FileManagerEntity)paramObject).combinePhotoList.size() > 0)) {
      return ((FileManagerEntity)((FileManagerEntity)paramObject).combinePhotoList.get(0)).getSortTime();
    }
    if ((paramObject instanceof PadInfo)) {
      return ((PadInfo)paramObject).getSortTime();
    }
    if ((paramObject instanceof atkw)) {
      return ((atkw)paramObject).getSortTime();
    }
    return 0L;
  }
  
  public static String cn(long paramLong)
  {
    return new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong));
  }
  
  public static String co(long paramLong)
  {
    return new SimpleDateFormat("yyyy").format(Long.valueOf(paramLong));
  }
  
  public static String cp(long paramLong)
  {
    return new SimpleDateFormat("MM-dd HH:mm").format(Long.valueOf(paramLong));
  }
  
  public static String cq(long paramLong)
  {
    try
    {
      String str = cr(paramLong);
      if (str.equals("今天")) {
        return cn(paramLong);
      }
      if (str.equals("昨天")) {
        return "昨天 " + cn(paramLong);
      }
      str = cp(paramLong);
      return str;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return "";
  }
  
  public static String cr(long paramLong)
    throws ParseException
  {
    return nV(y(paramLong));
  }
  
  public static String nU(String paramString)
  {
    paramString = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return null;
  }
  
  public static String nV(String paramString)
    throws ParseException
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject2 = nU(paramString);
    String str = Fg();
    localObject2 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
    localObject1 = ((SimpleDateFormat)localObject1).parse(str);
    if (((Date)localObject1).getTime() - ((Date)localObject2).getTime() == 0L) {
      return "今天";
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 86400000L)) {
      return "昨天";
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 604800000L)) {
      return "一周内";
    }
    localObject1 = paramString.substring(0, 4);
    paramString = paramString.substring(5, 7);
    return (String)localObject1 + "年" + paramString + "月";
  }
  
  public static String y(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqb
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zsh
{
  public static LocalMediaInfo a(Context paramContext, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMediaType = 0;
    localLocalMediaInfo.path = paramString;
    paramString = new BitmapFactory.Options();
    paramString.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(localLocalMediaInfo.path, paramString);
    localLocalMediaInfo.mediaWidth = paramString.outWidth;
    localLocalMediaInfo.mediaHeight = paramString.outHeight;
    if (paramBoolean)
    {
      localLocalMediaInfo.thumbWidth = 0;
      localLocalMediaInfo.thumbHeight = ((int)paramContext.getResources().getDimension(2131297340));
      if ((localLocalMediaInfo.mediaWidth > 0) && (localLocalMediaInfo.mediaHeight > 0)) {
        FlowThumbDecoder.determineThumbSize(localLocalMediaInfo, localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplacePhotoDataUtil", 1, new Object[] { "convert to mediaInfo, cost:", Long.valueOf(System.currentTimeMillis() - l) });
      }
      return localLocalMediaInfo;
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
    }
  }
  
  public static LocalMediaInfo a(Map<LocalMediaInfo, LocalMediaInfo> paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramString.equals(((LocalMediaInfo)localEntry.getValue()).path)) {
        return (LocalMediaInfo)localEntry.getKey();
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, Intent paramIntent, boolean paramBoolean, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PhotoConst.editPathMap");
    LocalMediaInfo localLocalMediaInfo;
    if (paramIntent != null)
    {
      Iterator localIterator = paramIntent.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramHashMap = (Map.Entry)localIterator.next();
        paramIntent = a(paramContext, (String)paramHashMap.getKey(), paramBoolean);
        localLocalMediaInfo = a(paramContext, (String)paramHashMap.getValue(), paramBoolean);
        paramHashMap = a((Map)localObject, (String)paramHashMap.getKey());
        if (paramHashMap == null) {
          break label127;
        }
        paramIntent = paramHashMap;
      }
    }
    label127:
    for (;;)
    {
      ((HashMap)localObject).put(paramIntent, localLocalMediaInfo);
      break;
      return;
    }
  }
  
  public static void a(Context paramContext, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    LocalMediaInfo localLocalMediaInfo;
    if (paramHashMap1 != null)
    {
      Iterator localIterator = paramHashMap1.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramHashMap1 = (Map.Entry)localIterator.next();
        paramHashMap = a(paramContext, (String)paramHashMap1.getKey(), false);
        localLocalMediaInfo = a(paramContext, (String)paramHashMap1.getValue(), false);
        paramHashMap1 = a((Map)localObject, (String)paramHashMap1.getKey());
        if (paramHashMap1 == null) {
          break label113;
        }
        paramHashMap = paramHashMap1;
      }
    }
    label113:
    for (;;)
    {
      ((HashMap)localObject).put(paramHashMap, localLocalMediaInfo);
      break;
      return;
    }
  }
  
  public static void a(List<LocalMediaInfo> paramList, ArrayList<String> paramArrayList, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Iterator localIterator1 = paramHashMap.entrySet().iterator();
    label183:
    for (;;)
    {
      Map.Entry localEntry;
      if (localIterator1.hasNext())
      {
        localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          paramHashMap = (LocalMediaInfo)localIterator2.next();
        } while (!paramHashMap.path.equals(((LocalMediaInfo)localEntry.getKey()).path));
      }
      for (;;)
      {
        if (paramHashMap == null) {
          break label183;
        }
        int i = paramList.indexOf(paramHashMap);
        paramList.remove(paramHashMap);
        paramList.add(i, localEntry.getValue());
        ((LocalMediaInfo)localEntry.getValue()).position = Integer.valueOf(i);
        if (paramArrayList == null) {
          break;
        }
        i = paramArrayList.indexOf(paramHashMap.path);
        paramArrayList.remove(paramHashMap.path);
        paramArrayList.add(i, ((LocalMediaInfo)localEntry.getValue()).path);
        break;
        return;
        paramHashMap = null;
      }
    }
  }
  
  public static boolean a(String paramString, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext()) {
      if (((LocalMediaInfo)((Map.Entry)paramHashMap.next()).getValue()).path.equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public static String b(Map<String, String> paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  public static HashMap<String, String> d(HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(((LocalMediaInfo)localEntry.getKey()).path, ((LocalMediaInfo)localEntry.getValue()).path);
    }
    return localHashMap;
  }
  
  public static HashMap<String, String> e(HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    HashMap localHashMap = new HashMap(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localHashMap.put(((LocalMediaInfo)localEntry.getKey()).path, ((LocalMediaInfo)localEntry.getValue()).path);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsh
 * JD-Core Version:    0.7.0.1
 */
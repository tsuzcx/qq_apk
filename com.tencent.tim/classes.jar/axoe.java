import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.tavcut.bean.Size;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class axoe
{
  public static void a(int paramInt, @Nullable Activity paramActivity, @Nullable PhotoCommonBaseData paramPhotoCommonBaseData, @Nullable String paramString, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramPhotoCommonBaseData == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramPhotoCommonBaseData.selectedPhotoList);
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean))
    {
      a(paramInt, paramPhotoCommonBaseData.albumName, paramPhotoCommonBaseData.albumId, paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, paramString);
      return;
    }
    int i = axcg.y.getId();
    if (axcg.az(paramActivity.getIntent())) {
      i = axcg.A.getId();
    }
    if (paramInt == 1)
    {
      a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i);
      return;
    }
    a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i);
  }
  
  public static void a(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, @Nullable String paramString3)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null) || (paramString3 == null)) {}
    Bundle localBundle;
    int i;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.SELECTED_PATHS", paramArrayList);
      localBundle.putString("res_path", paramString3);
      localBundle.putString("albumName", paramString1);
      localBundle.putString("albumId", paramString2);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      i = axcg.y.getId();
      if (axcg.az(paramActivity.getIntent())) {
        i = axcg.A.getId();
      }
      if (paramInt == 0)
      {
        axjh.a(paramActivity, 0, localBundle, i);
        return;
      }
    } while (paramInt != 1);
    axjh.a(paramActivity, 1, localBundle, i);
  }
  
  public static void a(@Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent.putExtra("video_photo_from", paramInt);
    avpw.U(paramActivity, localIntent);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if ((paramContext == null) || (paramString == null) || (paramLocalMediaInfo == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramLocalMediaInfo);
    paramString = new Intent();
    paramString.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramString.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    paramString.putExtra("video_photo_from", paramInt);
    avpw.U(paramContext, paramString);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable Size paramSize, @Nullable ArrayList paramArrayList, int paramInt)
  {
    if ((paramContext == null) || (paramString2 == null) || (paramString1 == null) || (paramSize == null)) {}
    while (!new File(paramString2).exists()) {
      return;
    }
    paramString2 = axof.a(paramSize.getHeight(), paramSize.getWidth(), paramString1, paramString2, paramString3);
    if (paramArrayList != null) {
      paramString2.aiTextLabel = paramArrayList;
    }
    a(paramContext, paramString1, paramString2, paramInt);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramContext == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent1 = new Intent();
    if ((paramContext instanceof Activity))
    {
      Intent localIntent2 = ((Activity)paramContext).getIntent();
      if ((localIntent2 != null) && (localIntent2.getExtras() != null)) {
        localIntent1.putExtras(localIntent2.getExtras());
      }
    }
    localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent1.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent1.putExtra("video_photo_from", paramInt);
    avpw.U(paramContext, localIntent1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axoe
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.soso.LbsManagerService;

public class zeh
{
  public static Long a()
  {
    String str = LbsManagerService.getCityCode();
    if (TextUtils.isEmpty(str))
    {
      ykq.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      ykq.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ykq.e("LocationUtils", "getCityCode() cityCode is not number!");
      bdjw.a(zfc.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
  
  public static wlk a(EditVideoParams paramEditVideoParams)
  {
    wlk localwlk2 = wll.a();
    wlk localwlk1;
    int j;
    int i;
    if (paramEditVideoParams.isEditLocal())
    {
      localwlk1 = null;
      paramEditVideoParams = paramEditVideoParams.mEditSource;
      if ((paramEditVideoParams instanceof EditLocalVideoSource))
      {
        paramEditVideoParams = ((EditLocalVideoSource)paramEditVideoParams).a;
        j = paramEditVideoParams.latitude;
        i = paramEditVideoParams.longitude;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0))
      {
        localwlk1 = new wlk(j, i, 0);
        ykq.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localwlk1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localwlk2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localwlk1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zeh
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class xnd
{
  public static Long a()
  {
    String str = amkv.b();
    if (TextUtils.isEmpty(str))
    {
      wsv.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      wsv.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      wsv.e("LocationUtils", "getCityCode() cityCode is not number!");
      azlf.a(xny.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
  
  public static utj a(com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    utj localutj2 = utk.a();
    utj localutj1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localutj1 = null;
      paramEditVideoParams = paramEditVideoParams.a;
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
        localutj1 = new utj(j, i, 0);
        wsv.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localutj1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localutj2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localutj1;
    }
  }
  
  public static utj a(dov.com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    utj localutj2 = utk.a();
    utj localutj1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localutj1 = null;
      paramEditVideoParams = paramEditVideoParams.a;
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
        localutj1 = new utj(j, i, 0);
        wsv.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localutj1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localutj2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localutj1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnd
 * JD-Core Version:    0.7.0.1
 */
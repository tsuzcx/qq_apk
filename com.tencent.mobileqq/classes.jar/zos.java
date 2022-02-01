import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class zos
{
  public static Long a()
  {
    String str = apch.b();
    if (TextUtils.isEmpty(str))
    {
      yuk.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      yuk.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      yuk.e("LocationUtils", "getCityCode() cityCode is not number!");
      bdkh.a(zpn.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
  
  public static wuz a(com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    wuz localwuz2 = wva.a();
    wuz localwuz1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localwuz1 = null;
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
        localwuz1 = new wuz(j, i, 0);
        yuk.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localwuz1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localwuz2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localwuz1;
    }
  }
  
  public static wuz a(dov.com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    wuz localwuz2 = wva.a();
    wuz localwuz1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localwuz1 = null;
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
        localwuz1 = new wuz(j, i, 0);
        yuk.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localwuz1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localwuz2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localwuz1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zos
 * JD-Core Version:    0.7.0.1
 */
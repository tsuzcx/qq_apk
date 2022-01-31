import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class vyl
{
  public static Long a()
  {
    String str = akuf.b();
    if (TextUtils.isEmpty(str))
    {
      ved.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      ved.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ved.e("LocationUtils", "getCityCode() cityCode is not number!");
      axpu.a(vzg.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
  
  public static ter a(com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    ter localter2 = tes.a();
    ter localter1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localter1 = null;
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
        localter1 = new ter(j, i, 0);
        ved.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localter1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localter2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localter1;
    }
  }
  
  public static ter a(dov.com.tencent.biz.qqstory.takevideo.EditVideoParams paramEditVideoParams)
  {
    ter localter2 = tes.a();
    ter localter1;
    int j;
    int i;
    if (paramEditVideoParams.d())
    {
      localter1 = null;
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
        localter1 = new ter(j, i, 0);
        ved.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localter1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localter2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localter1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyl
 * JD-Core Version:    0.7.0.1
 */
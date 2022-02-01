import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.soso.LbsManagerService;

public class ypo
{
  public static Long a()
  {
    String str = LbsManagerService.getCityCode();
    if (TextUtils.isEmpty(str))
    {
      xvv.b("LocationUtils", "getCityCode() lbsInfo.location.cityCode is empty");
      return null;
    }
    try
    {
      long l = Long.parseLong(str);
      xvv.a("LocationUtils", "getCityCode() lbsInfo.location.cityCode is %d", Long.valueOf(l));
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      xvv.e("LocationUtils", "getCityCode() cityCode is not number!");
      bcdb.a(yqj.a("LocationUtils getCityCode() error", localNumberFormatException), "LocationUtils getCityCode() error");
    }
    return null;
  }
  
  public static vwp a(EditVideoParams paramEditVideoParams)
  {
    vwp localvwp2 = vwq.a();
    vwp localvwp1;
    int j;
    int i;
    if (paramEditVideoParams.isEditLocal())
    {
      localvwp1 = null;
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
        localvwp1 = new vwp(j, i, 0);
        xvv.a("LocationUtils", "Use LocalMediaInfo Lat/Lng to Request POIList %s", paramEditVideoParams);
        return localvwp1;
        if ((paramEditVideoParams instanceof EditLocalPhotoSource))
        {
          paramEditVideoParams = ((EditLocalPhotoSource)paramEditVideoParams).a;
          j = paramEditVideoParams.latitude;
          i = paramEditVideoParams.longitude;
        }
      }
      else
      {
        return localvwp2;
      }
      i = 0;
      j = 0;
      paramEditVideoParams = localvwp1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypo
 * JD-Core Version:    0.7.0.1
 */
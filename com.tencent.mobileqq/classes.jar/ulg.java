import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class ulg
{
  public boolean a;
  
  private boolean a(DownloadInfo paramDownloadInfo, ule paramule)
  {
    if ((paramDownloadInfo == null) || (paramule == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramule.d)) || (TextUtils.isEmpty(paramule.d))) {
      return false;
    }
    return paramDownloadInfo.e.equals(paramule.d);
  }
  
  private void d(ule paramule)
  {
    udt.a(paramule, new ulh(this, paramule));
  }
  
  public void a() {}
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, ule paramule)
  {
    if (a(paramDownloadInfo, paramule)) {
      paramule.a = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, ule paramule)
  {
    if (a(paramDownloadInfo, paramule)) {
      c(paramule);
    }
  }
  
  public void a(String paramString1, String paramString2, ule paramule)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramule)) {
      a(paramule);
    }
  }
  
  public void a(List<DownloadInfo> paramList, ule paramule)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramule))
        {
          paramule.a = 3;
          if ((TextUtils.isEmpty(paramule.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramule.c = localDownloadInfo.d;
          }
          if (!this.a)
          {
            this.a = true;
            a();
          }
          a(paramule, localDownloadInfo.f);
        }
      }
    }
  }
  
  void a(ule paramule) {}
  
  public void a(ule paramule, int paramInt) {}
  
  public void b(DownloadInfo paramDownloadInfo, ule paramule)
  {
    if (a(paramDownloadInfo, paramule)) {
      b(paramule);
    }
  }
  
  public void b(String paramString1, String paramString2, ule paramule)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramule)) {
      d(paramule);
    }
  }
  
  public void b(ule paramule) {}
  
  public void c(String paramString1, String paramString2, ule paramule) {}
  
  public void c(ule paramule) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulg
 * JD-Core Version:    0.7.0.1
 */
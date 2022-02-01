import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class qpn
  extends JobSegment<List<String>, List<Bitmap>>
{
  private String TAG = "story.icon.UrlListToBitmapListSegment";
  private String axX;
  private qpm b;
  private int bnv;
  private final Bitmap ct;
  
  public qpn(@Nullable Bitmap paramBitmap, String paramString, int paramInt, qpm paramqpm)
  {
    this.ct = paramBitmap;
    this.TAG = (this.TAG + "[" + paramString + "]");
    this.axX = paramString;
    this.bnv = paramInt;
    this.b = paramqpm;
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      notifyError(new ErrorMessage(-1, "url list is empty"));
    }
    for (;;)
    {
      return;
      paramJobContext = Collections.unmodifiableList(paramList);
      int i = paramJobContext.size();
      paramList = new Bitmap[i];
      Arrays.fill(paramList, this.ct);
      qpb.b(this.TAG, "bitmapListSize = %d, stubBitmap = %s", Integer.valueOf(i), this.ct);
      Handler localHandler = new Handler(ThreadManager.getSubThreadLooper(), new qpn.a(null));
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramList), 300L);
      i = this.bnv / 2;
      Iterator localIterator = paramJobContext.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"stub_url".equals(str)) {
          this.b.a(str, i, i, new qpo(this, paramJobContext, paramList, localHandler));
        }
      }
    }
  }
  
  class a
    implements Handler.Callback
  {
    private a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      int k = 0;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 1: 
        qpn.a(qpn.this, new Error((Throwable)paramMessage.obj));
        return true;
      }
      paramMessage = (Bitmap[])paramMessage.obj;
      int m = paramMessage.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (paramMessage[i] == null) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            qpn.a(qpn.this, Arrays.asList(paramMessage));
          }
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpn
 * JD-Core Version:    0.7.0.1
 */
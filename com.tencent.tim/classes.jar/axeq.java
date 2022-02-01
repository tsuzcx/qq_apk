import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4.1;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.4.2;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class axeq
  implements axfx.a
{
  axeq(axem paramaxem, boolean paramBoolean) {}
  
  public void HS(String paramString)
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateSuccess, come from AECAMERA_MODE_ALL");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    String str1;
    String str2;
    if (!axem.a(this.this$0)) {
      if (axem.a(this.this$0) != null)
      {
        str1 = axem.a(this.this$0).HK();
        localArrayList1.add(paramString);
        localArrayList2.add(str1);
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        if (axem.b(this.this$0) != null) {
          break label217;
        }
        str2 = "";
        label107:
        localArrayList3.add(str2);
        if (!this.dun) {
          break label228;
        }
        axem.a(this.this$0, localArrayList1, localArrayList2, localArrayList3);
        this.this$0.getActivity().setResult(201);
        this.this$0.getActivity().finish();
        paramString = this.this$0.getActivity().getApplicationContext();
        ThreadManager.getUIHandler().post(new AEGIFSinglePreviewFragment.4.1(this, paramString));
      }
    }
    for (;;)
    {
      axem.a(this.this$0);
      return;
      str1 = "";
      break;
      str1 = axem.a(this.this$0);
      break;
      label217:
      str2 = axem.b(this.this$0);
      break label107;
      label228:
      axem.a(this.this$0, localArrayList1, localArrayList2, localArrayList3);
      if ((axem.b(this.this$0)) && (axem.a(this.this$0) != null)) {
        axem.a(this.this$0, paramString, axem.a(this.this$0), str1, axem.b(this.this$0));
      } else {
        ayja.a(axem.a(this.this$0), paramString, axcg.G(this.this$0.getActivity()), true, str1, axem.b(this.this$0));
      }
    }
  }
  
  public void cZr()
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateFail");
    axem.a(this.this$0);
    aurs.runOnUiThread(new AEGIFSinglePreviewFragment.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axeq
 * JD-Core Version:    0.7.0.1
 */
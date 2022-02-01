import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;

public class tne
  implements tnd
{
  private tnf a;
  
  public tne(tnf paramtnf)
  {
    this.a = paramtnf;
  }
  
  private String oq()
  {
    Object localObject2 = null;
    if (this.a != null) {}
    for (Activity localActivity = this.a.getActivity();; localActivity = null)
    {
      Object localObject1 = localObject2;
      if (localActivity != null)
      {
        localObject1 = localObject2;
        if (localActivity.getIntent() != null)
        {
          long l = localActivity.getIntent().getLongExtra("GdtNocoId", -1L);
          localObject1 = localObject2;
          if (l != -1L) {
            localObject1 = String.valueOf(l);
          }
        }
      }
      return localObject1;
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934594L) {}
    try
    {
      paramString = oq();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.callJs("!function(g,d,t,e,v,n,s){if(g.gdt)return;v=g.gdt=function(){v.tk?v.tk.apply(v,arguments):v.queue.push(arguments)};v.sv=\"1.0\";v.bt=2;v.queue=[];n=d.createElement(t);n.async=!0;n.src=e;s=d.getElementsByTagName(t)[0];s.parentNode.insertBefore(n,s);}(window,document,\"script\",\"//qzonestyle.gtimg.cn/qzone/biz/gdt/dmp/user-action/gdtevent.min.js\");gdt(\"init\",\"userActionSetId\");gdt(\"track\",\"PAGE_VIEW\");".replace("userActionSetId", paramString));
        tkw.d("GdtWebReportNoco", "GdtWebReportPlugin Report nocoId :" + paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tne
 * JD-Core Version:    0.7.0.1
 */
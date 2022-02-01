import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aytw
  extends aygz
{
  public Activity activity;
  public String bdK;
  public boolean bwI;
  public boolean bxD = true;
  public boolean bxE;
  public boolean bxH = true;
  public int cig = -1;
  public boolean dAK = true;
  public boolean dAL;
  public boolean dAM;
  public boolean dAN;
  public boolean dAO;
  public boolean dAP;
  public boolean dAQ;
  public boolean dAR;
  public int eMO;
  private int eMP = -1;
  public ArrayList<String> eo;
  public int fontId = -1;
  public boolean isTopic;
  public String mContent = "";
  public String mFontUrl;
  public int mPriv = 1;
  public String pO;
  public QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;
  public int superFontId = -1;
  public boolean topicSyncQzone = true;
  public String uO;
  public View zJ;
  
  public aytw(Activity paramActivity)
  {
    this.activity = paramActivity;
    if (paramActivity.getIntent().getIntExtra("qqstory_slide_show_scene", -1) == 22) {}
    for (;;)
    {
      this.dAQ = bool;
      this.eMP = paramActivity.getIntent().getIntExtra("qqstory_slide_show_entrance", -1);
      return;
      bool = false;
    }
  }
  
  private ayun a()
  {
    Iterator localIterator = getParts().iterator();
    while (localIterator.hasNext())
    {
      aygy localaygy = (aygy)localIterator.next();
      if ((localaygy instanceof ayun)) {
        return (ayun)localaygy;
      }
    }
    return null;
  }
  
  static void h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.a locala = new QZoneClickReport.a();
    locala.actionType = paramString1;
    locala.cMI = paramString2;
    locala.reserves = paramString3;
    QZoneClickReport.report(QQStoryContext.a().mi(), locala, paramBoolean);
  }
  
  public void a(ayii paramayii, EditVideoParams paramEditVideoParams)
  {
    super.a(paramayii, paramEditVideoParams);
    if ((paramEditVideoParams != null) && (paramEditVideoParams.mExtra != null) && ((this.eMP == 17) || (this.eMP == 18)))
    {
      paramayii = this.activity.getResources().getString(2131721085);
      paramEditVideoParams.mExtra.putString("extra_publish_text", paramayii);
    }
  }
  
  public void afI(int paramInt)
  {
    ayun localayun = a();
    if (localayun != null) {
      localayun.p(paramInt, null);
    }
  }
  
  public void bsV()
  {
    super.bsV();
    afI(3005);
  }
  
  public void bsn()
  {
    h("608", "1", "0", true);
    if ((!this.dAL) && (this.eMO > 0)) {
      aniq.dFI /= this.eMO;
    }
    super.bsn();
  }
  
  public void cF(Context paramContext)
  {
    super.cF(paramContext);
  }
  
  protected void eS(List<aygy> paramList)
  {
    if ((!this.dAQ) || ((this.eMP != 14) && (this.eMP != 19))) {
      paramList.add(new ayto(this));
    }
    if (this.dAQ) {
      paramList.add(new ayhq(this));
    }
    if ((this.dAM) && (!this.dAQ)) {
      paramList.add(new ayup(this, this.activity));
    }
    if (this.qzoneVerticalVideoTopicInfo != null) {
      paramList.add(new ayuj(this, this.qzoneVerticalVideoTopicInfo));
    }
    paramList.add(new ayun(this));
  }
  
  public void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    h(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void pauseVideo()
  {
    if (this.a != null) {
      this.a.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytw
 * JD-Core Version:    0.7.0.1
 */
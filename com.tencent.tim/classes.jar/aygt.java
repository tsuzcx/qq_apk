import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class aygt
  extends aygy
{
  private StoryGuideLineView a;
  private boolean dzb;
  
  public aygt(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public static void a(StoryGuideLineView paramStoryGuideLineView)
  {
    ThreadManager.excute(new EditVideoLimitRegion.1(paramStoryGuideLineView), 16, null, true);
  }
  
  private boolean aQy()
  {
    try
    {
      if (this.a != null) {
        return true;
      }
      this.b.a().bsC();
      this.a = ((StoryGuideLineView)y(2131372903));
      a(this.a);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "makeSureInitLayout error : " + localException.getMessage());
      }
    }
    return false;
  }
  
  protected boolean e(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = super.e(paramMessage);
      do
      {
        do
        {
          return bool;
          if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof aygt.a))) {
            break;
          }
          aygt.a locala = (aygt.a)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + locala.dzf + " right : " + locala.dze + " top : " + locala.dzc + " bottom : " + locala.dzd);
          }
          if (locala.aIq)
          {
            g(locala.dzf, locala.dze, locala.dzc, locala.dzd);
            break;
          }
          this.a.eTe();
          break;
        } while (!aQy());
        if (paramMessage.arg1 == 1)
        {
          this.a.eSX();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLink");
          break;
        }
        if (paramMessage.arg1 != 0) {
          break;
        }
        this.a.eSY();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "hideLink");
        break;
      } while (!aQy());
      if (paramMessage.arg1 == 1)
      {
        this.a.eSV();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showStoryTag");
        }
      }
      else if (paramMessage.arg1 == 3)
      {
        this.a.eSW();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "hideStoryTag");
        }
      }
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!aQy()) {
      return;
    }
    if ((!paramBoolean3) || (paramBoolean4))
    {
      Object localObject;
      if (!this.a.aQS())
      {
        localObject = this.b.b();
        rmw localrmw = this.b.b();
        if (localObject != null) {
          this.a.setLinkerObject((aypi)localObject);
        }
        if (this.dzb) {
          this.a.setFollow();
        }
        if (localrmw != null) {
          this.a.setStoryTag(localrmw);
        }
      }
      if ((this.b instanceof aytw))
      {
        localObject = this.a;
        if (!((aytw)this.b).dAQ)
        {
          paramBoolean3 = true;
          ((StoryGuideLineView)localObject).ZI(paramBoolean3);
          label124:
          if (!paramBoolean2) {
            break label173;
          }
          this.a.eTa();
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label183;
      }
      this.a.eTc();
      return;
      paramBoolean3 = false;
      break;
      this.a.ZI(true);
      break label124;
      this.a.eSZ();
      break label124;
      label173:
      this.a.eTb();
    }
    label183:
    this.a.eTd();
  }
  
  public void onResume()
  {
    super.onResume();
    aQy();
  }
  
  public static class a
  {
    public boolean aIq;
    public boolean dzc;
    public boolean dzd;
    public boolean dze;
    public boolean dzf;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      this.dzc = paramBoolean1;
      this.dzd = paramBoolean2;
      this.dze = paramBoolean3;
      this.dzf = paramBoolean4;
      this.aIq = paramBoolean5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygt
 * JD-Core Version:    0.7.0.1
 */
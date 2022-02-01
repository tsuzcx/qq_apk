import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.8.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.b;

public class aymd
  implements ayjn.c
{
  public aymd(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(ayjn.b paramb)
  {
    boolean bool = false;
    if (DoodleLayout.a(this.this$0)) {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onEditFaceItem mIsRecording");
      }
    }
    while (((DoodleLayout.b(this.this$0)) && (!DoodleLayout.c(this.this$0))) || (this.this$0.a == null)) {
      return false;
    }
    this.this$0.a.setVisibility(0);
    DoodleLayout.d(this.this$0);
    if (paramb.eGY == 3) {
      this.this$0.post(new DoodleLayout.8.1(this));
    }
    this.this$0.a.a.d(paramb);
    paramb.aIp = true;
    SegmentKeeper localSegmentKeeper = paramb.mSegmentKeeper;
    if (!this.this$0.a.aQN()) {
      bool = true;
    }
    localSegmentKeeper.lockData(bool);
    if ((paramb.eGY == 1) || (paramb.eGY == 3)) {
      paramb.drawable.setCallback(this.this$0.a);
    }
    this.this$0.a.requestLayout();
    return true;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (DoodleLayout.b(this.this$0)) {
      return;
    }
    this.this$0.b(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void xj(int paramInt)
  {
    if (this.this$0.b != null) {
      this.this$0.b.eb(1, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymd
 * JD-Core Version:    0.7.0.1
 */
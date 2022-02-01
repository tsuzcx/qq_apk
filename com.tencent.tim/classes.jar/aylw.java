import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class aylw
  implements aykb.a
{
  public aylw(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(aykb.b paramb)
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.setVisibility(0);
      DoodleLayout.d(this.this$0);
      this.this$0.a.a.d(paramb);
      paramb.aIp = true;
      paramb = paramb.mSegmentKeeper;
      if (!this.this$0.a.aQN()) {}
      for (boolean bool = true;; bool = false)
      {
        paramb.lockData(bool);
        this.this$0.a.requestLayout();
        rar.a("video_shoot_new", "qa_edit", 2, 0, new String[0]);
        return true;
      }
    }
    return false;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.this$0.b(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void eRT()
  {
    ram.d("DoodleLayout", "deleteInteractPaster.");
    if (DoodleLayout.a(this.this$0) != null)
    {
      aydk localaydk = (aydk)DoodleLayout.a(this.this$0).a(aydk.class);
      if (localaydk != null) {
        localaydk.eQK();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylw
 * JD-Core Version:    0.7.0.1
 */
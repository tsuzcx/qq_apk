import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.common.app.AppInterface;

public class qre
{
  private akll a;
  public MystoryListView a;
  protected NewMessageYellowBar b;
  protected AppInterface mApp;
  private boolean mCreated;
  
  public qre()
  {
    this.jdField_a_of_type_Akll = new qrf(this);
  }
  
  public void a(AppInterface paramAppInterface, View paramView, MystoryListView paramMystoryListView)
  {
    if (!(paramView instanceof NewMessageYellowBar)) {
      throw new IllegalArgumentException("StoryHomePushYellowBarHandler 传入View不对");
    }
    this.mApp = paramAppInterface;
    this.b = ((NewMessageYellowBar)paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = paramMystoryListView;
    this.b.setOnClickListener(new qrg(this));
    this.mApp.addObserver(this.jdField_a_of_type_Akll);
    this.mCreated = true;
  }
  
  public void bpS()
  {
    if (this.b == null) {
      return;
    }
    this.b.dX(0, 0);
    ((jnv)this.mApp.getManager(70)).nY(21);
  }
  
  public void onAccountChanged()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Akll);
    }
    this.mApp = QQStoryContext.c();
    if (this.mCreated) {
      this.mApp.addObserver(this.jdField_a_of_type_Akll);
    }
  }
  
  public void onDestroy()
  {
    this.mCreated = false;
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Akll);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qre
 * JD-Core Version:    0.7.0.1
 */
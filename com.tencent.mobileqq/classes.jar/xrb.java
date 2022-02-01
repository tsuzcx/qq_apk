import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class xrb
  extends xpo
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private xmn jdField_a_of_type_Xmn;
  private xre jdField_a_of_type_Xre;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public xrb(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131380803));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, xmt paramxmt, @NonNull ArrayList<xqz> paramArrayList)
  {
    yuk.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramxmt);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramxmt, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Xre == null) {
        this.jdField_a_of_type_Xre = new xre(this);
      }
      wjj.a().registerSubscriber("", this.jdField_a_of_type_Xre);
    }
    if ((paramxmt.c()) || (paramxmt.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Xmn.a().size();
      this.jdField_a_of_type_Xmn.a(paramInt, paramArrayList, paramxmt.a);
    } while (i == this.jdField_a_of_type_Xmn.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Xmn = new xmn(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Xmn);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new xrc(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new xrd(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Xre != null)
    {
      this.d = false;
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xre);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.b();
  }
  
  public boolean isValidate()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrb
 * JD-Core Version:    0.7.0.1
 */
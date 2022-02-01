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

public class wsm
  extends wqz
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private wny jdField_a_of_type_Wny;
  private wsp jdField_a_of_type_Wsp;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public wsm(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131380529));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, woe paramwoe, @NonNull ArrayList<wsk> paramArrayList)
  {
    xvv.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramwoe);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramwoe, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Wsp == null) {
        this.jdField_a_of_type_Wsp = new wsp(this);
      }
      vli.a().registerSubscriber("", this.jdField_a_of_type_Wsp);
    }
    if ((paramwoe.c()) || (paramwoe.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Wny.a().size();
      this.jdField_a_of_type_Wny.a(paramInt, paramArrayList, paramwoe.a);
    } while (i == this.jdField_a_of_type_Wny.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Wny = new wny(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Wny);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new wsn(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new wso(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Wsp != null)
    {
      this.d = false;
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wsp);
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
 * Qualified Name:     wsm
 * JD-Core Version:    0.7.0.1
 */
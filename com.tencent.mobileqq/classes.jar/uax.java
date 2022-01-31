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

public class uax
  extends tzk
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private twj jdField_a_of_type_Twj;
  private uba jdField_a_of_type_Uba;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public uax(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131378952));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, twp paramtwp, @NonNull ArrayList<uav> paramArrayList)
  {
    veg.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramtwp);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtwp, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Uba == null) {
        this.jdField_a_of_type_Uba = new uba(this);
      }
      ste.a().registerSubscriber("", this.jdField_a_of_type_Uba);
    }
    if ((paramtwp.c()) || (paramtwp.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Twj.a().size();
      this.jdField_a_of_type_Twj.a(paramInt, paramArrayList, paramtwp.a);
    } while (i == this.jdField_a_of_type_Twj.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Twj = new twj(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Twj);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new uay(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new uaz(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Uba != null)
    {
      this.d = false;
      ste.a().unRegisterSubscriber(this.jdField_a_of_type_Uba);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uax
 * JD-Core Version:    0.7.0.1
 */
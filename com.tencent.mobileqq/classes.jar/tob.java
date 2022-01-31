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

public class tob
  extends tmo
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private tjn jdField_a_of_type_Tjn;
  private toe jdField_a_of_type_Toe;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public tob(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131313128));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, tjt paramtjt, @NonNull ArrayList<tnz> paramArrayList)
  {
    urk.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramtjt);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramtjt, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Toe == null) {
        this.jdField_a_of_type_Toe = new toe(this);
      }
      sgi.a().registerSubscriber("", this.jdField_a_of_type_Toe);
    }
    if ((paramtjt.c()) || (paramtjt.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Tjn.a().size();
      this.jdField_a_of_type_Tjn.a(paramInt, paramArrayList, paramtjt.a);
    } while (i == this.jdField_a_of_type_Tjn.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Tjn = new tjn(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Tjn);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new toc(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new tod(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Toe != null)
    {
      this.d = false;
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Toe);
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
 * Qualified Name:     tob
 * JD-Core Version:    0.7.0.1
 */
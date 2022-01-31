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

public class vtv
  extends vsi
  implements IEventReceiver
{
  private long jdField_a_of_type_Long;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private vph jdField_a_of_type_Vph;
  private vty jdField_a_of_type_Vty;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public vtv(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131379669));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void a(int paramInt, vpn paramvpn, @NonNull ArrayList<vtt> paramArrayList)
  {
    wxe.a("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramvpn);
    boolean bool = this.jdField_a_of_type_Boolean;
    super.a(paramInt, paramvpn, paramArrayList);
    if (!bool)
    {
      this.d = true;
      if (this.jdField_a_of_type_Vty == null) {
        this.jdField_a_of_type_Vty = new vty(this);
      }
      umc.a().registerSubscriber("", this.jdField_a_of_type_Vty);
    }
    if ((paramvpn.c()) || (paramvpn.b())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Vph.a().size();
      this.jdField_a_of_type_Vph.a(paramInt, paramArrayList, paramvpn.a);
    } while (i == this.jdField_a_of_type_Vph.a().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(paramString);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_Vph = new vph(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Vph);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new vtw(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new vtx(this));
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Vty != null)
    {
      this.d = false;
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vty);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtv
 * JD-Core Version:    0.7.0.1
 */
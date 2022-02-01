import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class qjs
  extends qir
  implements IEventReceiver
{
  private long AN;
  private boolean Dr;
  private VideoCoverListBar jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  private qgw jdField_a_of_type_Qgw;
  private qjs.a jdField_a_of_type_Qjs$a;
  private boolean aDJ;
  private volatile boolean mIsScrolling;
  
  public qjs(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public void a(int paramInt, qgy.d paramd, @NonNull ArrayList<qjq> paramArrayList)
  {
    ram.b("VideoCoverListGroupHolder", "onBind() pos=%d, group=%s", Integer.valueOf(paramInt), paramd);
    boolean bool = this.aDy;
    super.a(paramInt, paramd, paramArrayList);
    if (!bool)
    {
      this.Dr = true;
      if (this.jdField_a_of_type_Qjs$a == null) {
        this.jdField_a_of_type_Qjs$a = new qjs.a(this);
      }
      pmi.a().registerSubscriber("", this.jdField_a_of_type_Qjs$a);
    }
    if ((paramd.JA()) || (paramd.Jz())) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Qgw.getData().size();
      this.jdField_a_of_type_Qgw.a(paramInt, paramArrayList, paramd.d);
    } while (i == this.jdField_a_of_type_Qgw.getData().size());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.bom();
  }
  
  public void bon()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.bon();
  }
  
  public void boy()
  {
    super.boy();
    if (this.jdField_a_of_type_Qjs$a != null)
    {
      this.Dr = false;
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qjs$a);
    }
  }
  
  public boolean isValidate()
  {
    return this.Dr;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Qgw = new qgw(a().mUIStyle.showVideoCoverList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.a(this.jdField_a_of_type_Qgw);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnVideoClickListener(new qjt(this));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.setOnScrollListener(new qju(this));
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar = ((VideoCoverListBar)paramViewGroup.findViewById(2131381655));
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar;
  }
  
  public void rF(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar.rF(paramString);
  }
  
  public static class a
    extends QQUIEventReceiver<qjs, pyc.a>
  {
    public a(@NonNull qjs paramqjs)
    {
      super();
    }
    
    public void a(@NonNull qjs paramqjs, @NonNull pyc.a parama)
    {
      if ((parama.b.isFail()) || (parama.mVideoList == null)) {
        return;
      }
      if (qjs.b(paramqjs))
      {
        qjs.b(paramqjs, true);
        ram.d("VideoCoverListGroupHolder", "base info return , notify list while idle");
        return;
      }
      paramqjs.bon();
      ram.d("VideoCoverListGroupHolder", "base info return , notify list now");
    }
    
    public Class acceptEventClass()
    {
      return pyc.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjs
 * JD-Core Version:    0.7.0.1
 */
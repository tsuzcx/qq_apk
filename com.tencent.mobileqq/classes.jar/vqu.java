import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowListLoadEvent;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.qqcircle.manager.QCircleSpecialFollowManager.2;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFollowListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StRelationInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class vqu
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private final aaak jdField_a_of_type_Aaak = aaak.a();
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  private final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final vqy jdField_a_of_type_Vqy = new vqy(this.jdField_a_of_type_AndroidOsHandler, null);
  private vra jdField_a_of_type_Vra;
  private boolean jdField_a_of_type_Boolean;
  
  private vqu()
  {
    this.jdField_a_of_type_Aaak.a(this.jdField_a_of_type_Vqy);
  }
  
  public static vqu a()
  {
    return vqz.a();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aaak.a(new QCircleSpecialFollowUpdateEvent(paramString, paramBoolean));
  }
  
  private void a(vrb paramvrb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aaak.a(new QCircleSpecialFollowListLoadEvent(paramvrb, paramBoolean));
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QCircleSpecialFollowManager.2(this, paramBoolean, paramString));
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_JavaUtilSet.size();
    int i = j;
    if (this.jdField_a_of_type_Vra != null) {
      i = j + 1;
    }
    QLog.d("QCircleSpecialFollowMgr", 4, "getSpecialFollowCnt: " + i);
    return i;
  }
  
  public void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (str.equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = str;
    try
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
    finally {}
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, boolean paramBoolean)
  {
    int i = 0;
    String str = paramStUser.id.get();
    QLog.d("QCircleSpecialFollowMgr", 4, "doSpecialFollow: " + str + " " + paramBoolean);
    if (TextUtils.isEmpty(str))
    {
      b("设置失败", false);
      return;
    }
    if (paramBoolean) {
      i = 1;
    }
    paramStUser = new QCircleDoFollowRequest(paramStUser, i, null, true);
    VSNetworkHelper.a().a(paramStUser, new vqv(this, paramBoolean, str));
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int += 1;
      int i = this.jdField_a_of_type_Int;
      QLog.d("QCircleSpecialFollowMgr", 4, "updateSpecialFollowList: " + i);
      QCircleGetFollowListRequest localQCircleGetFollowListRequest = new QCircleGetFollowListRequest(null, 0L, true);
      VSNetworkHelper.a().a(localQCircleGetFollowListRequest, new vqw(this, i));
      return;
    }
    finally {}
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Vra == null)
    {
      QLog.w("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: wrong");
      b();
      return;
    }
    vra localvra = this.jdField_a_of_type_Vra;
    QCircleGetFollowListRequest localQCircleGetFollowListRequest = new QCircleGetFollowListRequest(vra.a(localvra), vra.a(localvra), true);
    VSNetworkHelper.a().a(localQCircleGetFollowListRequest, new vqx(this, localvra));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    FeedCloudMeta.StRelationInfo localStRelationInfo;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      paramMessage = (String)paramMessage.obj;
      QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: follow " + paramMessage);
      this.jdField_a_of_type_JavaUtilSet.add(paramMessage);
      a(paramMessage, true);
      return true;
    case 1002: 
      paramMessage = (String)paramMessage.obj;
      QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: cancel " + paramMessage);
      this.jdField_a_of_type_JavaUtilSet.remove(paramMessage);
      a(paramMessage, false);
      if ((this.jdField_a_of_type_JavaUtilSet.size() < 99) && (this.jdField_a_of_type_Vra != null)) {
        c();
      }
      return true;
    case 1003: 
      this.jdField_a_of_type_JavaUtilSet.clear();
      paramMessage = (vrb)paramMessage.obj;
      QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: update " + vrb.a(paramMessage) + " " + paramMessage.jdField_a_of_type_JavaUtilList.size());
      localIterator = paramMessage.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localStRelationInfo = (FeedCloudMeta.StRelationInfo)localIterator.next();
        this.jdField_a_of_type_JavaUtilSet.add(localStRelationInfo.id.get());
      }
      this.jdField_a_of_type_Vra = paramMessage.jdField_a_of_type_Vra;
      a(paramMessage, true);
      return true;
    case 1004: 
      paramMessage = (vrb)paramMessage.obj;
      QLog.d("QCircleSpecialFollowMgr", 1, "handleMessage: more " + vrb.a(paramMessage) + " " + paramMessage.jdField_a_of_type_JavaUtilList.size());
      if ((this.jdField_a_of_type_Vra == null) || (vra.a(this.jdField_a_of_type_Vra) != vrb.a(paramMessage))) {
        return true;
      }
      localIterator = paramMessage.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localStRelationInfo = (FeedCloudMeta.StRelationInfo)localIterator.next();
        this.jdField_a_of_type_JavaUtilSet.add(localStRelationInfo.id.get());
      }
      this.jdField_a_of_type_Vra = paramMessage.jdField_a_of_type_Vra;
      a(paramMessage, false);
      return true;
    }
    a(null, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */
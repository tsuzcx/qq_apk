import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vpp
{
  private static String jdField_a_of_type_JavaLangString = "QCirclePolyLikeInfoManger";
  public static HashMap<String, AnimationView.AnimationInfo> a;
  private static vpp jdField_a_of_type_Vpp;
  private float jdField_a_of_type_Float = 0.0F;
  private List<QQCircleFeedBase.StPolyLike> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static vpp a()
  {
    try
    {
      if (jdField_a_of_type_Vpp == null) {
        jdField_a_of_type_Vpp = new vpp();
      }
      vpp localvpp = jdField_a_of_type_Vpp;
      return localvpp;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    QCircleGetTabListRequest localQCircleGetTabListRequest = new QCircleGetTabListRequest(null);
    localQCircleGetTabListRequest.setJustQueryRewardInfo(paramBoolean);
    vpq localvpq = new vpq(this, localQCircleGetTabListRequest, paramBoolean);
    VSNetworkHelper.a().a(localQCircleGetTabListRequest, localvpq);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public List<QQCircleFeedBase.StPolyLike> a()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = bgjb.a(BaseApplicationImpl.getApplication(), "qcircle_stpoly_key");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("#");
        if (localObject.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < localObject.length) {}
      try
      {
        QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)new QQCircleFeedBase.StPolyLike().mergeFrom(localObject[i].getBytes());
        this.jdField_a_of_type_JavaUtilList.add(localStPolyLike);
        label79:
        i += 1;
        continue;
        QLog.d(jdField_a_of_type_JavaLangString, 4, "get poly success from share:" + this.jdField_a_of_type_JavaUtilList.size());
        if (this.jdField_a_of_type_JavaUtilList.isEmpty())
        {
          QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697253, 0);
          a(false);
        }
        return this.jdField_a_of_type_JavaUtilList;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        break label79;
      }
    }
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "updateCurrentMoney result: " + this.jdField_a_of_type_Float);
  }
  
  public void a(List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      zwk localzwk = new zwk();
      int i = 0;
      while (i < paramList.size())
      {
        QQCircleFeedBase.StPolyLike localStPolyLike1 = (QQCircleFeedBase.StPolyLike)paramList.get(i);
        QQCircleFeedBase.StPolyLike localStPolyLike2 = uxx.a(localStPolyLike1);
        this.jdField_a_of_type_JavaUtilList.add(localStPolyLike2);
        localzwk.a(new zwn(localStPolyLike2.polySource.get(), uwz.a()));
        if (!TextUtils.isEmpty(localStPolyLike1.fullScreenURLAND.get())) {
          localzwk.a(new zwn(localStPolyLike2.fullScreenURLAND.get(), uwz.a()));
        }
        localStringBuilder.append(new String(localStPolyLike1.toByteArray())).append("#");
        i += 1;
      }
      if (!TextUtils.isEmpty(localStringBuilder.toString()))
      {
        localzwk.a();
        QLog.d(jdField_a_of_type_JavaLangString, 4, "set poly success:" + this.jdField_a_of_type_JavaUtilList.size());
        bgjb.a(BaseApplicationImpl.getApplication(), "qcircle_stpoly_key", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpp
 * JD-Core Version:    0.7.0.1
 */
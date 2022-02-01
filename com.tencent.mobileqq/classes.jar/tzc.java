import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/PublicAccountNewBridgeInvokeHandler$getUserInfo$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tzc
  implements qhl
{
  tzc(String paramString1, tza paramtza, String paramString2) {}
  
  public void onLoadUserInfoFailed(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errMsg");
    this.jdField_a_of_type_Tza.a(this.jdField_a_of_type_JavaLangString, uta.a(paramString2));
  }
  
  public void onLoadUserInfoSucceed(@NotNull String paramString, @NotNull ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyUserInfo, "userInfo");
    this.jdField_a_of_type_Tza.a(this.jdField_a_of_type_JavaLangString, uta.a(paramReadInJoyUserInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzc
 * JD-Core Version:    0.7.0.1
 */
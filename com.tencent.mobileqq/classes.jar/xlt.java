import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

final class xlt
  extends SimpleJob<Object>
{
  xlt(String paramString, wjn paramwjn, String[] paramArrayOfString, int paramInt, xlu paramxlu, TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.jdField_a_of_type_Wjn.a();
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = blhn.a(this.jdField_a_of_type_ArrayOfJavaLangString[0], "authkey", paramJobContext);
    }
    xlo.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, this.jdField_a_of_type_ArrayOfJavaLangString[0], this.jdField_a_of_type_Xlu);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlt
 * JD-Core Version:    0.7.0.1
 */
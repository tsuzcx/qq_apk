import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class ywz
  implements bohc
{
  ywz(ywx paramywx) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = ywx.a(this.a).getResources().getString(2131698028);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new yxk();
        ((yxk)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((yxk)localObject).d = paramObject.url;
        ((yxk)localObject).jdField_b_of_type_Int = 2;
        ((yxk)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = ywx.a(this.a).getResources().getString(2131698029);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class yig
  implements bmrk
{
  yig(yie paramyie) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = yie.a(this.a).getResources().getString(2131697745);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new yir();
        ((yir)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((yir)localObject).d = paramObject.url;
        ((yir)localObject).jdField_b_of_type_Int = 2;
        ((yir)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = yie.a(this.a).getResources().getString(2131697746);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class zhg
  implements bpmp
{
  zhg(zhe paramzhe) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = zhe.a(this.a).getResources().getString(2131697599);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new zhr();
        ((zhr)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((zhr)localObject).d = paramObject.url;
        ((zhr)localObject).jdField_b_of_type_Int = 2;
        ((zhr)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = zhe.a(this.a).getResources().getString(2131697600);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhg
 * JD-Core Version:    0.7.0.1
 */
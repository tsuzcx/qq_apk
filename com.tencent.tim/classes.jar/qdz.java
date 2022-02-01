import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.qphone.base.util.QLog;

public class qdz
  extends ppv.c<pzs, pzs.a>
{
  public qdz(StoryShareEncryptHelper.2 param2, long paramLong, arhz paramarhz) {}
  
  public void a(@NonNull pzs parampzs, @Nullable pzs.a parama, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.AG) + ", resp:" + parama);
    }
    rar.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.AG) });
    this.a.a.a(parama, this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qdz
 * JD-Core Version:    0.7.0.1
 */
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class awqr
  implements awqd.a
{
  awqr(awqq paramawqq, String paramString, long paramLong, awqb paramawqb, int paramInt) {}
  
  public void a(awpy paramawpy, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramawpy == null) || (!TextUtils.equals(this.fb, paramawpy.fileId))) {
      return;
    }
    if (paramBoolean)
    {
      if (paramawpy.a == null)
      {
        awqq.a(this.jdField_b_of_type_Awqq).onFetchError(this.val$dbId, 1810024, "");
        return;
      }
      awqq.a(this.jdField_b_of_type_Awqq).a(this.val$dbId, paramawpy.a);
      return;
    }
    if ((paramInt == 1002) && (!this.jdField_b_of_type_Awqb.aNq()))
    {
      this.jdField_b_of_type_Awqb.Xo(true);
      paramawpy = Message.obtain();
      paramawpy.what = 21;
      paramawpy.obj = this.jdField_b_of_type_Awqb;
      paramawpy.arg1 = this.Zi;
      awqq.a(this.jdField_b_of_type_Awqq).sendMessageDelayed(paramawpy, 1000L);
      return;
    }
    awqq.a(this.jdField_b_of_type_Awqq).onFetchError(this.val$dbId, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqr
 * JD-Core Version:    0.7.0.1
 */
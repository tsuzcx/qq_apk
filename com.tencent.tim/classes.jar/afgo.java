import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afgo
  implements affx.a
{
  afgo(afgn paramafgn) {}
  
  public void jS(List<afmi> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= afhs.cQV) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= afhs.cQW) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.this$0.b != null) {
      this.this$0.b.jV((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgo
 * JD-Core Version:    0.7.0.1
 */
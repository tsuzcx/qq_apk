import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class msj
  implements msg.b
{
  msj(msg parammsg) {}
  
  public void aa(JSONObject paramJSONObject)
  {
    msg.a(this.this$0, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + msg.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msj
 * JD-Core Version:    0.7.0.1
 */
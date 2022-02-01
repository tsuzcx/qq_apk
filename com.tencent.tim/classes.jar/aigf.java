import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;

class aigf
  implements ActionCallback
{
  aigf(aigd paramaigd) {}
  
  public void onResult(String paramString)
  {
    try
    {
      i = Integer.parseInt(paramString);
      if (aigd.a(this.this$0) != null) {
        aigd.a(this.this$0).callback(i, "");
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigf
 * JD-Core Version:    0.7.0.1
 */
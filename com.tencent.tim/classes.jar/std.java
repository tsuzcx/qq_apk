import org.json.JSONObject;

class std
  implements auuw.b
{
  std(ssx paramssx, String paramString) {}
  
  public void a(auuw.a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    switch (parama.id)
    {
    default: 
      return;
    case 0: 
      try
      {
        localJSONObject.put("index", 0);
        this.this$0.callJs(this.val$callback, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 1);
      this.this$0.callJs(this.val$callback, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     std
 * JD-Core Version:    0.7.0.1
 */
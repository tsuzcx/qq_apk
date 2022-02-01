import org.json.JSONObject;

class tks
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    try
    {
      paramtjs.callJs(paramString, new String[] { new JSONObject().toString() });
      return true;
    }
    catch (Throwable paramtjs)
    {
      tkw.e("GdtOSVersionJsCall", "handleJsCallRequest", paramtjs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tks
 * JD-Core Version:    0.7.0.1
 */
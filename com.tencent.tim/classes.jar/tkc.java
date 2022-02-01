import org.json.JSONObject;

class tkc
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    try
    {
      paramtjs.callJs(paramString, new String[] { new JSONObject().toString() });
      return false;
    }
    catch (Throwable paramtjs)
    {
      tkw.e("GdtDeviceInfoJsCallHandler", "handleJsCallRequest error", paramtjs);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkc
 * JD-Core Version:    0.7.0.1
 */
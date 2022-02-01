import org.json.JSONObject;

class tkp
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject();
      paramVarArgs.put("lat", JSONObject.NULL);
      paramVarArgs.put("lon", JSONObject.NULL);
      paramtjs.callJs(paramString, new String[] { paramVarArgs.toString() });
      return true;
    }
    catch (Throwable paramtjs)
    {
      tkw.e("GdtLocationJsCallHandler", "handleJsCallRequest", paramtjs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkp
 * JD-Core Version:    0.7.0.1
 */
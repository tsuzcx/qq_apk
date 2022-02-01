import org.json.JSONObject;

class tka
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    if (paramtjs != null) {}
    for (paramVarArgs = paramtjs.getActivity(); (paramtjs == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      tkw.e("GdtCarrierJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      paramtjs.callJs(paramString, new String[] { new JSONObject().toString() });
      return true;
    }
    catch (Throwable paramtjs)
    {
      tkw.e("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramtjs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tka
 * JD-Core Version:    0.7.0.1
 */
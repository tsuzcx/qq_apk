package com.tencent.qmsp.sdk.g.d;

import android.os.AsyncTask;

public class d
  extends AsyncTask<Void, Void, Boolean>
{
  public a a;
  public c b;
  
  public d(a parama, c paramc)
  {
    this.a = parama;
    this.b = paramc;
  }
  
  /* Error */
  protected Boolean a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 16	com/tencent/qmsp/sdk/g/d/d:a	Lcom/tencent/qmsp/sdk/g/d/a;
    //   6: ifnonnull +9 -> 15
    //   9: iconst_0
    //   10: invokestatic 28	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 16	com/tencent/qmsp/sdk/g/d/d:a	Lcom/tencent/qmsp/sdk/g/d/a;
    //   19: invokeinterface 34 1 0
    //   24: istore 4
    //   26: iload 4
    //   28: ifne +21 -> 49
    //   31: ldc2_w 35
    //   34: invokestatic 42	java/lang/Thread:sleep	(J)V
    //   37: iload_2
    //   38: iconst_1
    //   39: iadd
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: iload_3
    //   44: bipush 30
    //   46: if_icmplt -31 -> 15
    //   49: iload 4
    //   51: ifeq +19 -> 70
    //   54: aload_0
    //   55: getfield 18	com/tencent/qmsp/sdk/g/d/d:b	Lcom/tencent/qmsp/sdk/g/d/c;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +10 -> 70
    //   63: aload_1
    //   64: iconst_1
    //   65: invokeinterface 47 2 0
    //   70: iload 4
    //   72: invokestatic 28	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   75: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d
    //   0	76	1	paramVarArgs	Void[]
    //   1	42	2	i	int
    //   40	7	3	j	int
    //   24	47	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	26	14	java/lang/InterruptedException
    //   31	37	14	java/lang/InterruptedException
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.d.d
 * JD-Core Version:    0.7.0.1
 */
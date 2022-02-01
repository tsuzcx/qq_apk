package cooperation.mailplugin.ipc;

interface IMailRemoteInterface {
	boolean transfer(in String cmd, in Bundle params);
}
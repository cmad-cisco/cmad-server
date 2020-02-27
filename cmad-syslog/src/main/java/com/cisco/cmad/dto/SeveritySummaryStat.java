package com.cisco.cmad.dto;

public class SeveritySummaryStat {
	Count emerg, alert, crit, err, warn, notice, info, debug;

	public Count getEmerg() {
		return emerg;
	}

	public void setEmerg(Count emerg) {
		this.emerg = emerg;
	}

	public Count getAlert() {
		return alert;
	}

	public void setAlert(Count alert) {
		this.alert = alert;
	}

	public Count getCrit() {
		return crit;
	}

	public void setCrit(Count crit) {
		this.crit = crit;
	}

	public Count getErr() {
		return err;
	}

	public void setErr(Count err) {
		this.err = err;
	}

	public Count getWarn() {
		return warn;
	}

	public void setWarn(Count warn) {
		this.warn = warn;
	}

	public Count getNotice() {
		return notice;
	}

	public void setNotice(Count notice) {
		this.notice = notice;
	}

	public Count getInfo() {
		return info;
	}

	public void setInfo(Count info) {
		this.info = info;
	}

	public Count getDebug() {
		return debug;
	}

	public void setDebug(Count debug) {
		this.debug = debug;
	}

	@Override
	public String toString() {
		return "SeveritySummaryStat [emerg=" + emerg + ", alert=" + alert + ", crit=" + crit + ", err=" + err
				+ ", warn=" + warn + ", notice=" + notice + ", info=" + info + ", debug=" + debug + "]";
	}
	
}

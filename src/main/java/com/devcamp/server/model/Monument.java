package com.devcamp.server.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 1:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@XmlRootElement
public class Monument {
	@Id
	private ObjectId id;
    private String REF;
    private String ETUD;
    private String LOCA;
    private String REG;
    private String DPT;
    private String COM;
    private String INSEE;
    private String TICO;
    private String ADRS;
    private String STAT;
    private String AFFE;
    private String PPRO;
    private String AUTR;
    private String SCLE;



    public Monument(){

    }

    public Monument(String REF, String ETUD, String LOCA, String REG, String DPT, String COM, String INSEE, String TICO, String ADRS, String STAT, String AFFE, String PPRO, String AUTR, String SCLE) {
        this.REF = REF;
        this.ETUD = ETUD;
        this.LOCA = LOCA;
        this.REG = REG;
        this.DPT = DPT;
        this.COM = COM;
        this.INSEE = INSEE;
        this.TICO = TICO;
        this.ADRS = ADRS;
        this.STAT = STAT;
        this.AFFE = AFFE;
        this.PPRO = PPRO;
        this.AUTR = AUTR;
        this.SCLE = SCLE;
    }

    public String getREF() {
        return REF;
    }

    public void setREF(String REF) {
        this.REF = REF;
    }

    public String getETUD() {
        return ETUD;
    }

    public void setETUD(String ETUD) {
        this.ETUD = ETUD;
    }

    public String getLOCA() {
        return LOCA;
    }

    public void setLOCA(String LOCA) {
        this.LOCA = LOCA;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getDPT() {
        return DPT;
    }

    public void setDPT(String DPT) {
        this.DPT = DPT;
    }

    public String getCOM() {
        return COM;
    }

    public void setCOM(String COM) {
        this.COM = COM;
    }

    public String getINSEE() {
        return INSEE;
    }

    public void setINSEE(String INSEE) {
        this.INSEE = INSEE;
    }

    public String getTICO() {
        return TICO;
    }

    public void setTICO(String TICO) {
        this.TICO = TICO;
    }

    public String getADRS() {
        return ADRS;
    }

    public void setADRS(String ADRS) {
        this.ADRS = ADRS;
    }

    public String getSTAT() {
        return STAT;
    }

    public void setSTAT(String STAT) {
        this.STAT = STAT;
    }

    public String getAFFE() {
        return AFFE;
    }

    public void setAFFE(String AFFE) {
        this.AFFE = AFFE;
    }

    public String getPPRO() {
        return PPRO;
    }

    public void setPPRO(String PPRO) {
        this.PPRO = PPRO;
    }

    public String getAUTR() {
        return AUTR;
    }

    public void setAUTR(String AUTR) {
        this.AUTR = AUTR;
    }

    public String getSCLE() {
        return SCLE;
    }

    public void setSCLE(String SCLE) {
        this.SCLE = SCLE;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "REF='" + REF + '\'' +
                ", ETUD='" + ETUD + '\'' +
                ", LOCA='" + LOCA + '\'' +
                ", REG='" + REG + '\'' +
                ", DPT='" + DPT + '\'' +
                ", COM='" + COM + '\'' +
                ", INSEE='" + INSEE + '\'' +
                ", TICO='" + TICO + '\'' +
                ", ADRS='" + ADRS + '\'' +
                ", STAT='" + STAT + '\'' +
                ", AFFE='" + AFFE + '\'' +
                ", PPRO='" + PPRO + '\'' +
                ", AUTR='" + AUTR + '\'' +
                ", SCLE='" + SCLE + '\'' +
                '}';
    }
}

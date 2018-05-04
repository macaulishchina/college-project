package top.macaulish.orm;

import java.sql.Date;
import java.util.Objects;

public class MonitorInfoEntity {
    private int id;
    private String imei;
    private Date hardwareDate;
    private Double longitude;
    private Double latitude;
    private Double speed;
    private Date monitorDate;
    private String monitorIp;
    private Integer monitorPort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Date getHardwareDate() {
        return hardwareDate;
    }

    public void setHardwareDate(Date hardwareDate) {
        this.hardwareDate = hardwareDate;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Date getMonitorDate() {
        return monitorDate;
    }

    public void setMonitorDate(Date monitorDate) {
        this.monitorDate = monitorDate;
    }

    public String getMonitorIp() {
        return monitorIp;
    }

    public void setMonitorIp(String monitorIp) {
        this.monitorIp = monitorIp;
    }

    public Integer getMonitorPort() {
        return monitorPort;
    }

    public void setMonitorPort(Integer monitorPort) {
        this.monitorPort = monitorPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitorInfoEntity entity = (MonitorInfoEntity) o;
        return id == entity.id &&
                Objects.equals(imei, entity.imei) &&
                Objects.equals(hardwareDate, entity.hardwareDate) &&
                Objects.equals(longitude, entity.longitude) &&
                Objects.equals(latitude, entity.latitude) &&
                Objects.equals(speed, entity.speed) &&
                Objects.equals(monitorDate, entity.monitorDate) &&
                Objects.equals(monitorIp, entity.monitorIp) &&
                Objects.equals(monitorPort, entity.monitorPort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, imei, hardwareDate, longitude, latitude, speed, monitorDate, monitorIp, monitorPort);
    }
}

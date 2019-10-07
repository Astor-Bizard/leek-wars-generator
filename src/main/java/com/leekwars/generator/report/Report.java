package com.leekwars.generator.report;

import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;
import com.leekwars.generator.fight.statistics.FightStatistics;
import com.leekwars.generator.leek.LeekLog;

public class Report {
    /**
     * Fight: public data: entities, map, actions, flags, duration, ai times
     */
    public JSONObject fight;
    /**
     * Logs: debugs, marks, pauses
     */
    public Map<Integer, LeekLog> logs = new TreeMap<Integer, LeekLog>();
    /**
     * Winner team id
     */
    public int winner;
    /**
     * Fight statistics
     */
	public FightStatistics statistics;

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		JSONObject logsJSON = new JSONObject();
		for (Integer farmer : logs.keySet()) {
			logsJSON.put(String.valueOf(farmer), logs.get(farmer).toJSON());
		}
		json.put("fight", fight);
		json.put("logs", logsJSON);
		json.put("winner", winner);
		return json;
	}
}
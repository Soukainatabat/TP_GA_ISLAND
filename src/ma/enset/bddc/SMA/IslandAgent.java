package ma.enset.bddc.SMA;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ma.enset.bddc.GAUtils;
import ma.enset.bddc.Individual;

public class IslandAgent extends Agent {
    private Individual[] population = new Individual[GAUtils.POPULATION_SIZE];
    private  Individual individual1;
    public Individual individual2;

    @Override
    protected void setup() {
        DFAgentDescription dfAgentDescription = new DFAgentDescription();
        dfAgentDescription.setName(getAID());
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName("island");
        serviceDescription.setType("ga");
        dfAgentDescription.addServices(serviceDescription);

        try {
            DFService.register(this,dfAgentDescription);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }
}

package edu.coursera.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballEliminationTest {

    BaseballElimination baseballElimination;

    @Test
    public void shouldReadTeams4() {
        baseballElimination = new BaseballElimination("teams4.txt");

        assertThat(baseballElimination.teams())
                .containsExactlyInAnyOrder("Atlanta", "Philadelphia", "New_York", "Montreal");

        assertThat(baseballElimination.wins("Atlanta")).isEqualTo(83);
        assertThat(baseballElimination.losses("Atlanta")).isEqualTo(71);
        assertThat(baseballElimination.remaining("Atlanta")).isEqualTo(8);

        assertThat(baseballElimination.wins("Philadelphia")).isEqualTo(80);
        assertThat(baseballElimination.losses("Philadelphia")).isEqualTo(79);
        assertThat(baseballElimination.remaining("Philadelphia")).isEqualTo(3);

        assertThat(baseballElimination.wins("New_York")).isEqualTo(78);
        assertThat(baseballElimination.losses("New_York")).isEqualTo(78);
        assertThat(baseballElimination.remaining("New_York")).isEqualTo(6);

        assertThat(baseballElimination.wins("Montreal")).isEqualTo(77);
        assertThat(baseballElimination.losses("Montreal")).isEqualTo(82);
        assertThat(baseballElimination.remaining("Montreal")).isEqualTo(3);

        assertThat(baseballElimination.against("Atlanta", "Atlanta")).isEqualTo(0);
        assertThat(baseballElimination.against("Atlanta", "Philadelphia")).isEqualTo(1);
        assertThat(baseballElimination.against("Atlanta", "New_York")).isEqualTo(6);
        assertThat(baseballElimination.against("Atlanta", "Montreal")).isEqualTo(1);

        assertThat(baseballElimination.against("Philadelphia", "Atlanta")).isEqualTo(1);
        assertThat(baseballElimination.against("Philadelphia", "Philadelphia")).isEqualTo(0);
        assertThat(baseballElimination.against("Philadelphia", "New_York")).isEqualTo(0);
        assertThat(baseballElimination.against("Philadelphia", "Montreal")).isEqualTo(2);

        assertThat(baseballElimination.against("New_York", "Atlanta")).isEqualTo(6);
        assertThat(baseballElimination.against("New_York", "Philadelphia")).isEqualTo(0);
        assertThat(baseballElimination.against("New_York", "New_York")).isEqualTo(0);
        assertThat(baseballElimination.against("New_York", "Montreal")).isEqualTo(0);

        assertThat(baseballElimination.against("Montreal", "Atlanta")).isEqualTo(1);
        assertThat(baseballElimination.against("Montreal", "Philadelphia")).isEqualTo(2);
        assertThat(baseballElimination.against("Montreal", "New_York")).isEqualTo(0);
        assertThat(baseballElimination.against("Montreal", "Montreal")).isEqualTo(0);
    }

    @Test
    public void shouldFindEliminatedTeams4() {
        baseballElimination = new BaseballElimination("teams4.txt");

        assertThat(baseballElimination.isEliminated("Montreal")).isTrue();
        assertThat(baseballElimination.certificateOfElimination("Montreal"))
                .containsExactlyInAnyOrder("Atlanta");
    }

    @Test
    public void shouldFindEliminatedTeams5() {
        baseballElimination = new BaseballElimination("teams5.txt");

        assertThat(baseballElimination.isEliminated("Detroit")).isTrue();
        assertThat(baseballElimination.certificateOfElimination("Detroit"))
                .containsExactlyInAnyOrder("New_York", "Baltimore", "Boston", "Toronto");
    }

    @Test
    public void shouldFindEliminatedTeams10() {
        baseballElimination = new BaseballElimination("teams10.txt");
    }

    @Test
    public void shouldFindEliminatedTeams29() {
        baseballElimination = new BaseballElimination("teams29.txt");
    }

    @Test
    public void shouldFindEliminatedTeams60() {
        baseballElimination = new BaseballElimination("teams60.txt");
    }

}
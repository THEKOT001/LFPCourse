
data={
    "states" : 6,
    "letters" : ["a", "b"],
    "transitions" : [
        [0, "a", [0]],
        [1, "b", [1]],
        [1, "b", [2]],
        [0, "b", [1]],
        [1, "a", [0]],
        [2, "b", [1]]
    ],
    "start" : 0,
    "final": [2]
}

q = []
ntoDFA_states = 2 ** data["states"]
ntoDFA_letters = data["letters"]
ntoDFA_start = data["start"]
ntoDFA_trans = []
ntoDFA_final = []
ntoDFA_list = []
nfa_transitions = {}
ntoDFA_transitions = {}


q.append((ntoDFA_start,))



for transition in data["transitions"]:                      ##check if transitions coincide to group
    nfa_transitions[(transition[0], transition[1])] = transition[2]

for in_state in q:       ##current state of q
    for symbol in ntoDFA_letters:
        if len(in_state) == 1 and (in_state[0], symbol) in nfa_transitions:
            ntoDFA_transitions[(in_state, symbol)] = nfa_transitions[(in_state[0], symbol)]         ##checks for first tuple

            if tuple(ntoDFA_transitions[(in_state, symbol)]) not in q:
                q.append(tuple(ntoDFA_transitions[(in_state, symbol)]))         ##create new q with dfa state
        else:
            dest = []
            f_dest =[]

            for n_state in in_state:
                if (n_state, symbol) in nfa_transitions and nfa_transitions[(n_state, symbol)] not in dest:
                    dest.append(nfa_transitions[(n_state, symbol)])
            
            if dest:
                for d in dest:
                    for value in d:
                        if value not in f_dest:
                            f_dest.append(value)
            
                ntoDFA_transitions[(in_state, symbol)] = f_dest 

                if tuple(f_dest) not in q: 
                    q.append(tuple(f_dest))



for q_state in q:
    for f_state in data["final"]:
        if f_state in q_state:
            ntoDFA_final.append(q_state)


for key, value in ntoDFA_transitions.items():
    temp_list = [[key[0], key[1], value]]
    ntoDFA_trans.extend(temp_list)

DFA = {}
DFA["letters"] = ntoDFA_letters
DFA["transitions"] = ntoDFA_trans
DFA["start"] = ntoDFA_start
DFA["final"] = ntoDFA_final

print("Alphabet: ", DFA["letters"], "\n")
print("Transitions: ", DFA["transitions"], "\n")
print("Starting state: ", DFA["start"], "\n")
print("Final state: ", DFA["final"], "\n")